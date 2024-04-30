package com.homerunball.review.repository;

import com.homerunball.review.dto.ReviewDto;

public interface ReviewDao {
  ReviewDto selectAllReview(int pd_id);
}
