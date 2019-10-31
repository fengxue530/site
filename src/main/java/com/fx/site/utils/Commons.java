package com.fx.site.utils;

import com.fx.site.constant.WebConst;
import com.fx.site.entity.ContentEntity;
import com.github.pagehelper.PageInfo;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther: mabaofeng
 * @date: 2019/10/31 10:15
 * @description: 页面工具类，提供html页面一些函数方法，用于获取一些网站配置
 */
@Component
public class Commons {

    /**
     * 获得网站完整url
     *
     * @return
     */
    public static String site_url() {
        return site_url("");
    }

    /**
     * 使用拼接得到完整url
     *
     * @param sub
     * @return
     */
    public static String site_url(String sub) {
        return site_option("site_url") + sub;
    }

    /**
     * 重载方法，含有默认值的url获取
     *
     * @param key
     * @return
     */
    public static String site_option(String key) {
        return site_option(key, "");
    }

    /**
     * 从初始配置获取网站配置的通用方法
     *
     * @param key
     * @param defalutValue
     * @return
     */
    public static String site_option(String key, String defalutValue) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        String value = WebConst.initConfig.get(key);
        if (StringUtils.isEmpty(value)) {
            return defalutValue;
        } else {
            return value;
        }

    }

    /**
     * 将表情字符转为表情
     *
     * @param inputStr
     * @return
     */
    //TODO  没见过
    public static String emoji(String inputStr) {
        return EmojiParser.parseToUnicode(inputStr);
    }

    /**
     * 获取随机数加后缀的字符串
     * @param seed
     * @param max
     * @param str
     * @return
     */
    public static String random(Long seed, int max, String str) {
        if (seed == null) {
            seed = 1L;
        }
        Random random = new Random(seed);
        return random.nextInt(max) + str;
    }

    /**
     * 获取网站的备案信息
     * @return
     */
    public static String site_record() {
        return site_option("site_record");
    }

    /**
     * 获取网站标题
     * @return
     */
    public static String site_title() {
        return site_option("site_title");
    }

    /**
     * 获取GitHub地址
     * @return
     */
    public static String social_github(){
        return site_option("social_github");
    }

    /**
     * 获取google网站验证码
     * @return
     */
    public static String google_site_verification(){
        return site_option("google_site_verification");
    }

    /**
     * 获取百度网站验证码
     * @return
     */
    public static String baidu_site_verification(){
        return site_option("baidu_site_verification");
    }

    /**
     * 格式化unix时间戳为日期
     *
     * @param unixTime
     * @return
     */
    public static String fmtdate(Integer unixTime) {
        return fmtdate(unixTime, "yyyy-MM-dd");
    }

    /**
     * 格式化unix时间戳为日期
     *
     * @param unixTime
     * @param patten
     * @return
     */
    public static String fmtdate(Integer unixTime, String patten) {
        if (null != unixTime && StringUtils.isNotBlank(patten)) {
            return Dateutils.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }

    /**
     * 英文格式的日期
     * @param unixTime
     * @return
     */
    public static String fmtdate_en(Integer unixTime){
        String fmtdate = fmtdate(unixTime, "d,MMM,yyyy");
        String[] dateArr = fmtdate.split(",");
        String rs = "<span>" + dateArr[0] + "</span> " + dateArr[1] + "  " + dateArr[2];
        return rs;
    }


    /**
     * 英文格式的日期-月，日
     * @param unixTime
     * @return
     */
    public static String fmtdate_en_m(Integer unixTime){
        return fmtdate(unixTime,"MMM d");
    }

    /**
     * 日期-年
     * @param unixTime
     * @return
     */
    public static String fmtdate_en_y(Integer unixTime){
        return fmtdate(unixTime,"yyyy");
    }

    /**
     * 将中文的yyyy年MM月 - > yyyy
     * @param date
     * @return
     */
    public static String parsedate_zh_y_m(String date){
        if (StringUtils.isNotBlank(date)){
            return date.substring(0,4);
        }
        return null;
    }

    /**
     * 根据nuix时间戳获取Date
     * @param nuixTime
     * @return
     */
    public static Date fmtdate_unxtime(Integer nuixTime){
        if (null != nuixTime) {
            return new Date((long) nuixTime * 1000L);
        }
        return  null;
    }
    /**
     * 获取社交的链接地址
     *
     * @return
     */
    public static Map<String, String> social() {
        final String prefix = "social_";
        Map<String, String> map = new HashMap<>();
        map.put("csdn", WebConst.initConfig.get(prefix + "csdn"));
        map.put("jianshu", WebConst.initConfig.get(prefix + "jianshu"));
        map.put("resume", WebConst.initConfig.get(prefix + "resume"));
        map.put("weibo", WebConst.initConfig.get(prefix + "weibo"));
        map.put("zhihu", WebConst.initConfig.get(prefix + "zhihu"));
        map.put("github", WebConst.initConfig.get(prefix + "github"));
        map.put("twitter", WebConst.initConfig.get(prefix + "twitter"));
        return map;
    }

    /**
     * 如果blog没有配图，随机获取一张
     * @return
     */
    public static String randomBlogPic(Long seed){
        return "/site/images/blog-images/blog-" + random( seed,12,".jpg");
    }

    /**
     * 返回github头像地址
     *
     * @param email
     * @return
     */
    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isBlank(email)) {
            email = "user@hanshuai.xin";
        }
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

    /**
     * 显示文章内容，转换markdown为html
     *
     * @param value
     * @return
     */
    public static String article(String value) {
        if (StringUtils.isNotBlank(value)) {
            value = value.replace("<!--more-->", "\r\n");
            value = value.replace("<!-- more -->", "\r\n");
            return TaleUtils.mdToHtml(value);
        }
        return "";
    }

    /**
     * 返回文章链接地址
     *
     * @param contents
     * @return
     */
    public static String permalink(ContentEntity contents) {
        return permalink(contents.getCid(), contents.getSlug());
    }



    /**
     * 返回文章链接地址
     *
     * @param cid
     * @param slug
     * @return
     */
    public static String permalink(Integer cid, String slug) {
        return site_url("/article/" + (StringUtils.isNotBlank(slug) ? slug : cid.toString()));
    }

    /**
     * 判断分页中是否有数据
     *
     * @param paginator
     * @return
     */
    public static boolean is_empty(PageInfo paginator) {
        return paginator == null || (paginator.getList() == null) || (paginator.getList().size() == 0);
    }

    /**
     * 截取字符串
     *
     * @param str
     * @param len
     * @return
     */
    public static String substr(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len);
        }
        return str;
    }

    /**
     * 返回作品文章地址
     * @param cid
     * @return
     */
    public static String photoPermalink(Integer cid) {
        return site_url("/photo/article/" + cid.toString());
    }

    /**
     * 返回blog文章地址
     * @param cid
     * @return
     */
    public static String blogPermalink(Integer cid) {
        return site_url("/blog/article/" + cid.toString());
    }

    /**
     * 获取blog归档地址
     * @param date
     * @return
     */
    public static String archivePermalink(String date){
        return site_url("/blog/archives/" + date);
    }


    public static String archiveYearPermalink(String date){
        return site_url("/blog/archives/year/" + date);
    }
    /**
     * 返回blog分类的地址
     * @param categorie
     * @return
     */
    public static String categoriePermalink(String categorie){
        return site_url("/blog/categories/" + categorie);
    }

    /**
     * 返回blog标签页的地址
     * @param tag
     * @return
     */
    public static String tagPermalink(String tag){
        return site_url("/blog/tag/" + tag);
    }
    /**
     * 获取文章第一张图片
     *
     * @return
     */
    public static String show_thumb(String content) {
        content = TaleUtils.mdToHtml(content);
        if (content.contains("<img")) {
            String img = "";
            String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
            Pattern p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
            Matcher m_image = p_image.matcher(content);
            if (m_image.find()) {
                img = img + "," + m_image.group();
                // //匹配src
                Matcher m = Pattern.compile("src\\s*=\\s*\'?\"?(.*?)(\'|\"|>|\\s+)").matcher(img);
                if (m.find()) {
                    return m.group(1);
                }
            }
        }
        return "";
    }

    /**
     * 获取文章中的所有图片
     * @param content
     * @return
     */
    public static List<String> show_all_thumb(String content) {
        List<String> rs = new LinkedList();
        content = TaleUtils.mdToHtml(content);
        if (content.contains("<img")) {
            String img = "";
            String regEx_img = "<[a-zA-Z]+.*?>([\\s\\S]*?)</[a-zA-Z]*>";
            Pattern p_image = Pattern.compile(regEx_img, Pattern.MULTILINE);
            Matcher m_image = p_image.matcher(content);
            while (m_image.find()) {
                String data = m_image.group(1).trim();
                if(!"".equals(data) && data.contains("<img")) {
                    System.out.println(data);
                    // //匹配src
                    Matcher m = Pattern.compile("src\\s*=\\s*\'?\"?(.*?)(\'|\"|>|\\s+)").matcher(data);
                    if (m.find()) {
                        rs.add(m.group(1));
                    }
                }

            }
        }
        return rs;
    }

    /**
     * 获取文章的文字预览
     * @param content
     * @return
     */
    public static String show_p(String content){
        String result = "";
        content = TaleUtils.mdToHtml(content);
        String reg = "<[a-zA-Z]+.*?>([\\s\\S]*?)</[a-zA-Z]*>";

        Pattern p = Pattern.compile(reg, Pattern.MULTILINE);
        content = content.replace("&nbsp;", "");
        Matcher m = p.matcher(content);
        if (m.find()) {
            String data = m.group(1).trim();
            if(!"".equals(data) && !data.contains("<img")) {
                System.out.println(data);
                result = data;
            }
        }
        result = result.replace("<img>","");
        result = result.replace("</img>","");
        result = result.replace("<p>","");
        result = result.replace("</p>","");
        if (result.length() > 20)
            result = result.substring(0, 20);
        return result;
    }

    /**
     * 获取文章中所有的文字
     * @param content
     * @return
     */
    public static List<String> show_all_p(String content){
        List<String> rs = new LinkedList();
        content = TaleUtils.mdToHtml(content);
        String reg = "<[a-zA-Z]+.*?>([\\s\\S]*?)</[a-zA-Z]*>";

        Pattern p = Pattern.compile(reg, Pattern.MULTILINE);
        content = content.replace("&nbsp;", "");
        Matcher m = p.matcher(content);
        while(m.find()) {
            String data = m.group(1).trim();
            if(!"".equals(data) && !data.contains("<img")) {
                System.out.println(data);
                data = "<p>" + data + "</p>";
                rs.add(data);
            }
        }
        return rs;
    }

    /**
     * 显示分类
     *
     * @param categories
     * @return
     */
    public static String show_categories(String categories) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(categories)) {
            String[] arr = categories.split(",");
            StringBuffer sbuf = new StringBuffer();
            for (String c : arr) {
                sbuf.append("<a class=\"article-category-link\" href=\"/blog/category/" + URLEncoder.encode(c, "UTF-8") + "\">" + c + "</a>");
            }
            return sbuf.toString();
        }
        return show_categories("默认分类");
    }

    /**
     * 显示标签
     *
     * @param tags
     * @return
     */
    public static String show_tags(String tags) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(tags)) {
            String[] arr = tags.split(",");
            StringBuffer sbuf = new StringBuffer();
            for (String c : arr) {
                sbuf.append("<li class=\"article-tag-list-item\"><a href=\"/blog/tag/" + URLEncoder.encode(c, "UTF-8") + "\">#" + c + "</a></li>");
            }
            return sbuf.toString();
        }
        return "";
    }

    /**
     * 截取文章摘要
     *
     * @param value 文章内容
     * @param len   要截取文字的个数
     * @return
     */
    public static String intro(String value, int len) {
        Integer pos = value.indexOf("<!--more-->");
        if (null == pos || pos == 0 || pos == -1)
            pos = value.indexOf("<!-- more -->");
        if (pos != -1) {
            String html = value.substring(0, pos);
            return TaleUtils.mdToHtml(TaleUtils.mdToHtml(html));
        } else {
            String text = TaleUtils.mdToHtml(TaleUtils.mdToHtml(value));
            if (text.length() > len) {
                return text.substring(0, len);
            }
            return text;
        }
    }
}
