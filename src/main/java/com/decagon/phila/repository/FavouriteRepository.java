package com.decagon.phila.repository;

import com.decagon.phila.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavouriteRepository extends JpaRepository<Favourite,Long> {
    Optional<Favourite> findFavouriteByUserIdAndProductId(Long userId, Long productId);
    List<Favourite> findAllByUserId(Long id);
}
