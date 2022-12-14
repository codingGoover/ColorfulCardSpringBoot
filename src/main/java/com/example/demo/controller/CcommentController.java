package com.example.demo.controller;
import java.util.List;
import java.util.TimeZone;
import java.sql.Timestamp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.CcommentMapper;
import com.example.demo.model.Ccomment;

@RestController
public class CcommentController {

	
	private CcommentMapper mapper;
	
	public CcommentController(CcommentMapper mapper) {
		this.mapper=mapper;
	}

	@GetMapping("/ccomment/{pno}")
	public List<Ccomment> getCcomments(@PathVariable("pno")int pno) {
		
		return mapper.getCcomments(pno);
	}
	
	@PostMapping("/ccomment/{pno}")
	public Ccomment postCcomment(@PathVariable("pno")int pno, @RequestParam("cno")int cno,@RequestParam("ccno") int ccno,@RequestParam("ccid")String ccid, @RequestParam("ccment") String ccment)
	{
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
		Timestamp ccdate = new Timestamp(System.currentTimeMillis());
	

		 mapper.postCcomment(pno,cno,ccno,ccid,ccment,ccdate);
		 return mapper.getCcomment(pno,cno,ccno);
	}
	
	@DeleteMapping("/ccomment/delete")
	public int deleteCcomment(@RequestParam("pno")int pno, @RequestParam("cno")int cno, @RequestParam("ccno")int ccno)
	{
		return mapper.deleteCcomment(pno,cno,ccno);
	}
	
	
}
