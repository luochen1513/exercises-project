package com.book.controller;

import com.book.entity.Book;
import com.book.entity.User;
import com.book.entity.UserBook;
import com.book.service.BookService;
import com.book.service.UserBookService;
import com.book.service.UserService;
import com.book.util.CmdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * description:
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/27 22:14:14
 */
@Api(tags = "用户的书架")
@Controller
@RequestMapping("/userBook")
public class UserBookController extends BaseController {

    @Resource
    private UserBookService userBookService;

    @Resource
    private UserService userService;

    @Resource
    private BookService bookService;

    @ApiOperation("书架")
    @GetMapping("/userBook")
    public String userBook() {
        request.getSession().setAttribute("pageName", "借阅");
        return "userBook";
    }

    @ApiOperation("推荐")
    @GetMapping("/recommend")
    public String recommend() {
        request.getSession().setAttribute("pageName", "推荐");
        return "recommend";
    }

    /**
     * miss:
     * org.apache.ibatis.executor.ExecutorException: Error getting generated key or setting result
     * to parameter object. Cause: org.apache.ibatis.executor.ExecutorException: Could not determine
     * which parameter to assign generated keys to. Note that when there are multiple parameters,
     * 'keyProperty' must include the parameter name (e.g. 'param.id'). Specified key properties are
     * [id] and available parameters are [userId, param1, bookId, param2]
     * 将UserBook传给dao层
     */
    @ApiOperation("添加书架")
    @PostMapping("/userBookInsert")
    @ResponseBody
    public Map<String, Object> userBookInsert(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.queryByUsername(username);
        try {
            UserBook userBook = new UserBook();
            userBook.setUserId(user.getUserId());
            userBook.setBookId(book.getBookid());
            map = userBookService.userBookInsert(userBook);
            return map;
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
    }

    /**
     * 查询失败~nested exception is org.apache.ibatis.binding.BindingException: Parameter 'userId'
     * not found. Available parameters are [arg2, ew, arg0, param3, param1, param2]
     */
    @ApiOperation(value = "查询列表数据(包括分页,模糊,条件查询)")
    @PostMapping("/getList")
    @ResponseBody
    public Map<String, Object> getList(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        try {
            String username = (String) request.getSession().getAttribute("username");
            Integer userId = userService.queryByUsername(username).getUserId();
            map = userBookService.queryBooksByUserId(book, userId);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        map.put("success", true);
        return map;
    }

    @PostMapping("bookDelete")
    @ResponseBody
    @ApiOperation(value = "删除图书")
    public Map<String, Object> bookDeleteByBookId(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        try {
            userBookService.deleteByBookId(book.getBookid());
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }

    @ApiOperation(value = "查询列表数据(包括分页,模糊,条件查询)")
    @PostMapping("/recommendBook")
    @ResponseBody
    public Map<String, Object> recommendBook(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        List<Book> books = new ArrayList<>();
        Book query=null;
        try {
            String username = (String) request.getSession().getAttribute("username");
            Integer userId = userService.queryByUsername(username).getUserId();
            Map<Integer, String> cmd = CmdUtil.getCmd(String.valueOf(userId), "10");
            Set<Integer> bookIdList = cmd.keySet();
            for (Integer bookId : bookIdList) {
//                book.setBookid(bookId);
                query = bookService.queryById(bookId);
                if (query!=null){
                    books.add(query);
                }
            }
            map.put("data", books);
            map.put("success", true);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }
}
