package edu.mum.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.domain.Block;




public interface BlockRepository extends JpaRepository<Block, Long> {
	
	public Block findBlockByBlockMonth(@Param("blockMonth") String blockMonth);
	public List<Block> findByEntryId(Long id);
}
