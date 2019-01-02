package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.M2O.Post;
import com.example.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	PostRepository postRepo;
	
	//http://localhost:8181/getAllPost?page=0&size=3&sort=createdAt,asc
	@GetMapping("/getAllPost")
	public Page<Post> getAllPost(Pageable pageable){
		return postRepo.findAll(pageable);
	}
	
	@PostMapping("/createPost")
	public Post create(@Valid @RequestBody Post post) {
		return postRepo.saveAndFlush(post);
	}
	
	@PutMapping("/updatePost")
	public Post updatePost(@PathVariable Long postId,@RequestBody Post postRequest) {
		return postRepo.findById(postId).map(
			post->{
				post.setTitle(postRequest.getTitle());
				post.setContent(postRequest.getContent());
				post.setDescription(postRequest.getDescription());
				return postRepo.save(post);
			}
		).orElseThrow(()->new ResourceNotFoundException("Post"+postId+"Not Found"));
	}
	
	@DeleteMapping("/deletePost")
	public ResponseEntity<?> deletePost(@PathVariable Long postId){
		return postRepo.findById(postId).map(
					post->{
						postRepo.delete(post);
						return ResponseEntity.ok().build();
					}
				).orElseThrow(()->new ResourceNotFoundException("Post"+postId+"Not Found"));
	}
}
