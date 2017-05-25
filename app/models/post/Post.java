package models.post;

import java.util.*;

import models.comment.*;
import models.comment.repo.*;
import models.post.repo.*;
import models.user.*;

@Entity
public class Post extends Model {
    
    private final String title;
    //DateTimeが実現できない理由記述
    // hatanaka
    // yabeの構造上、DateTimeを使用するとバイナリーに変わってしまうので、
    // やむなくDateを使用している
    
    // harita 補足しておくと、
    // YabeではlocalのDBではなく、PlayFrameWorkが用意している仮想DBを用いて、処理を行っています。
    // そのため、DateTime型にしてしまうと、PlayFrameWorkのDBが想定しているバイナリー領域{ BINARY(2025) }を超えてしまうため、
    // 実現が難しいといったところです。
    
    private final Date postedAt;
    
    @Lob
    private final String content;
    
    @ManyToOne
    private final User author;
    
    public Post(final User author, final String title, final String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }
    
    public Post addComment(final String author, final String content) {
        final Comment newComment = new Comment(this, author, content).save();
        
        return this;
    }
    
    // 関連しているコメント
    public List<Comment> comments() {
        return CommentRepo.findByComment(this);
    }
    
    public Post previous() {
        return PostRepo.findByPostedAtPrevious(postedAt);
    }
    
    public Post next() {
        return PostRepo.findByPostedAtNext(postedAt);
    }
    
    /**
     * titleを取得します。
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * postedAtを取得します。
     *
     * @return postedAt
     */
    public Date getPostedAt() {
        return postedAt;
    }
    
    /**
     * contentを取得します。
     *
     * @return content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * authorを取得します。
     *
     * @return author
     */
    public User getAuthor() {
        return author;
    }
    
}
