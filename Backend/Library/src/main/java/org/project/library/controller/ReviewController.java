package org.project.library.controller;

import lombok.AllArgsConstructor;
import org.project.library.requestmodel.ReviewRequest;
import org.project.library.service.ReviewService;
import org.project.library.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;
    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization")String token, @RequestBody ReviewRequest reviewRequest) throws Exception{
        String userEmail =
                ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        if(userEmail == null) {
            throw new Exception("User email is missing");
        }
            reviewService.postReview(userEmail,reviewRequest);

    }
    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value = "Authorization")String token,@RequestParam Long bookId) throws Exception{
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        if(userEmail == null){
         throw new Exception("User email is missing");
        }
        return reviewService.userReviewListed(userEmail,bookId);
    }

}
