package com.homerunball.review.dao;

import com.homerunball.review.domain.ReviewDto;

public interface ReviewDao {
  ReviewDto selectAllReview(int pd_id);
}
