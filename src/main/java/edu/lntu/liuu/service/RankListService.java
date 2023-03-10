package edu.lntu.liuu.service;

import edu.lntu.liuu.domain.RankList;

public interface RankListService {

    boolean addRank(RankList rankList);

    int rankOfSongListId(Long songListId);

    int getUserRank(Long consumerId, Long songListId);

}
