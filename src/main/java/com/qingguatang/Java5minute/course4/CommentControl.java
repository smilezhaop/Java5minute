package com.qingguatang.Java5minute.course4;

import com.qingguatang.Java5minute.course4.model.Comment;
import com.qingguatang.Java5minute.course5.CommentPostControl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaopei
 * @date 2018/7/28
 */
@Controller
public class CommentControl {

  @Autowired
  private CommentPostControl commentPostControl;

  @RequestMapping(value = "/comments")
  public String comments(ModelMap modelMap) {
    List<Comment> comments = commentPostControl.getComments("35847388");
    modelMap.addAttribute("comments", comments);
    return "comments";
  }

  /*private List<Comment> getComment() {
    List<Comment> comments = commentPostControl.getComments("35847388")
    Comment comment = new Comment();
    comment.setIcon(
        "http://p1.music.126.net/vGKrH1IzLT27xF8TPEGE7Q==/109951163411337685.jpg?param=50y50");
    comment.setNickName("AriLuv");
    comment.setContent("hello！一转眼四年了！终于等到王者的归来~阿呆的全球屠榜又要开始啦！在此献上我的鸡腿！嘻嘻~");
    comment.setCommentTime("2015年10月23日");
    comment.setLikeNum(86826);
    comments.add(comment);

    comment = new Comment();
    comment.setIcon(
        "http://p1.music.126.net/eLZfXg6oY_xqWmd3hzQg-w==/109951163043012263.jpg?param=50y50");
    comment.setNickName("Edawn");
    comment.setContent("这hello应该翻译成别来无恙更恰当。");
    comment.setCommentTime("2015年12月13日");
    comment.setLikeNum(67933);
    comments.add(comment);

    return comments;
  }*/
}
