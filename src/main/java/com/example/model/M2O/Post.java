package com.example.model.M2O;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.model.audit.DateAudit;

//the best way to model a one-to-many relationship is to use just @ManyToOne annotation on the child entity
//The second best way is to define a bidirectional association with a @OneToMany annotation on the parent side of the relationship and a @ManyToOne annotation on the child side of the relationship.

@Entity
@Table(name = "posts")
public class Post extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Lob
    private String content;
    
    public Post() {
    	
    }
    
	public Post(@NotNull @Size(max = 100) String title, @NotNull @Size(max = 250) String description,
			@NotNull String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    
    
}
