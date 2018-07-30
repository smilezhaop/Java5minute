package com.qingguatang.Java5minute.course5;

import com.qingguatang.Java5minute.course4.model.Comment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhaopei
 * @date 2018/7/28
 */
@Controller
public class CommentPostControl {

  private static Map<String, List<Comment>> comments = new HashMap<>();

  @RequestMapping(value = "/comment/post")
  public String post(@RequestParam(value = "songId") String songId, Comment comment) {
    Date commentTime = new Date();
    comment.setCommentTime(commentTime);
    comment.setId(UUID.randomUUID().toString());
    comments.computeIfAbsent(songId, k->new ArrayList<>()).add(comment);

   /* List<Comment> res;
    if(comments.containsKey(songId)){
      res = comments.get(songId);
    }else {
      res = new ArrayList<>();
      comments.put(songId,res);
    }*/

    List<Comment> commentList = comments.get(songId);
    Collections.sort(commentList, new Comparator<Comment>() {
      @Override
      public int compare(Comment o1, Comment o2) {
        if(o1.getCommentTime().after(o2.getCommentTime())){
          return -1;
        }
        return 1;
      }
    });

    return "redirect:/comments";
  }

  public List<Comment> getComments(String songId){
    return comments.get(songId);
  }
}
