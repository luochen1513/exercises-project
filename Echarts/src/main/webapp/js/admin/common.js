function getQueryParam(name) {
    let regExp = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    let r = window.location.search.substr(1).match(regExp)
    if (r != null) {
        //反编码
        return decodeURIComponent(r[2]);
    }
    return '';
}