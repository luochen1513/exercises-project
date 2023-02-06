package com.book.controller;

import com.book.entity.Book;
import com.book.service.BookService;
import com.book.service.UserService;
import com.book.util.CmdUtil;
import com.book.util.CsvUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2022-06-26 11:56:40
 */
@Api(tags = "图书管理")
@Controller
@RequestMapping("book")
public class BookController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    @Resource
    private UserService userService;

    @ApiOperation("跳转图书列表")
    @GetMapping("bookList")
    public String bookList() {
        request.getSession().setAttribute("pageName", "图书管理");
        return "book-list";
    }

    @ApiOperation("跳转书城列表")
    @GetMapping("bookHouse")
    public String bookHouse() {
        request.getSession().setAttribute("pageName", "图书馆");
        return "bookHouse";
    }

    @ApiOperation("跳转添加图书页面")
    @GetMapping("insertBook")
    public String insertBook() {
        request.getSession().setAttribute("pageName", "添加图书");
        return "insertBook";
    }

    @ApiOperation("跳转修改图书页面")
    @GetMapping("updateBook")
    public String updateBook() {
        request.getSession().setAttribute("pageName", "修改图书");
        return "updateBook";
    }

    @ApiOperation("跳转图书详情页面")
    @GetMapping("selectBook")
    public String selectBook() {
        request.getSession().setAttribute("pageName", "图书详情");
        return "selectBook";
    }

    @ApiOperation("跳转图书详情页面")
    @GetMapping("selectBookRoot")
    public String selectBookRoot() {
        request.getSession().setAttribute("pageName", "图书详情");
        return "selectBookRoot";
    }

    @ApiOperation(value = "查询列表数据(包括分页,模糊,条件查询)")
    @PostMapping("getList")
    @ResponseBody
    public Map<String, Object> getList(@RequestBody Book book) {
        Map<String, Object> map = null;
        try {
            map = bookService.queryPageList(book);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }

    @PostMapping("bookSelect")
    @ApiOperation(value = "查看指定图书信息")
    @ResponseBody
    public Map<String, Object> bookSelect(Integer bookid) {
        Map<String, Object> map = new HashMap<>();
        Book book = null;
        try {
            book = bookService.queryById(bookid);
            String username = (String) request.getSession().getAttribute("username");
            Integer userId = userService.queryByUsername(username).getUserId();
            userService.updateHit(userId,bookid);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("data", book);
        return map;
    }

    @PostMapping("bookSelectRoot")
    @ApiOperation(value = "查看指定图书信息")
    @ResponseBody
    public Map<String, Object> bookSelectRoot(Integer bookid) {
        Map<String, Object> map = new HashMap<>();
        Book book = null;
        try {
            book = bookService.queryById(bookid);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("data", book);
        return map;
    }

    @PostMapping("bookUpdate")
    @ApiOperation(value = "修改指定图书信息")
    @ResponseBody
    public Map<String, Object> bookUpdate(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        try {
            bookService.update(book);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }

    @PostMapping("bookInsert")
    @ResponseBody
    @ApiOperation(value = "添加图书")
    public Map<String, Object> bookInsert(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        if ("".equals(book.getName()) || "".equals(book.getScore()) || "".equals(book.getPrice()) || "".equals(book.getPublish()) || "".equals(book.getUrl())) {
            map.put("success", false);
            map.put("errMsg", "不能有空白项");
            return map;
        } else {
            try {
                bookService.insert(book);
                map.put("success", true);
                return map;
            } catch (Exception e) {
                map.put("success", false);
                map.put("errMsg", e.getMessage());
                return map;
            }
        }
    }

    @PostMapping("bookDelete")
    @ResponseBody
    @ApiOperation(value = "删除图书")
    public Map<String, Object> bookDelete(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        try {
            bookService.deleteById(book.getBookid());
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }

    @ApiOperation("文件上传")
    @PostMapping("/file")
    @ResponseBody
    public Map<String, Object> file(@RequestBody Book book) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String bookFileName = book.getBookFileName();
        String path = "D:\\IDEA\\study\\keshe\\Book\\src\\main\\resources\\data\\" + bookFileName;
        System.out.println(path);
        String csv = (path.split("\\."))[1];
        if ("csv".equals(csv)) {
            String[] str = new String[]{"python",
                    "D:\\IDEA\\study\\keshe\\Book\\src\\main\\java\\com\\book\\python\\file.py", path};
            bookService.deleteBookTable();
            bookService.deleteBookTestTable();
            bookService.createBookTable();
            bookService.createBookTestTable();
            System.out.println("start upload");
            CmdUtil.fileupload(str);
            map.put("success", true);
            map.put("errMsg", "上传成功");
        } else if ("xls".equals(csv)) {
            String savePath = CsvUtil.getCsv(path, bookFileName);
            CsvUtil.encodingCsv(savePath, bookFileName);
            map.put("success", true);
            map.put("errMsg", "成功解析为csv");
        } else {
            map.put("success", false);
            map.put("errMsg", "请选择csv/xls文件");
        }
        return map;
    }
}

