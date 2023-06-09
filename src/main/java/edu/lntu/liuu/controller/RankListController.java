package edu.lntu.liuu.controller;

import edu.lntu.liuu.common.ErrorMessage;
import edu.lntu.liuu.common.SuccessMessage;
import edu.lntu.liuu.domain.RankList;
import edu.lntu.liuu.service.impl.RankListServiceImpl;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RankListController {

    @Autowired
    private RankListServiceImpl rankListService;

    // 提交评分
    @ResponseBody
    @RequestMapping(value = "/rankList/add", method = RequestMethod.POST)
    public Object addRank(HttpServletRequest req) {
        String songListId = req.getParameter("songListId").trim();
        String consumerId = req.getParameter("consumerId").trim();
        String score = req.getParameter("score").trim();

        RankList rank_list = new RankList();
        rank_list.setSongListId(Long.parseLong(songListId));
        rank_list.setConsumerId(Long.parseLong(consumerId));
        rank_list.setScore(Integer.parseInt(score));

        boolean res = rankListService.addRank(rank_list);
        if (res) {
            return new SuccessMessage<Null>("评价成功").getMessage();
        } else {
            return new ErrorMessage("评价失败").getMessage();
        }
    }

    // 获取指定歌单的评分
    @RequestMapping(value = "/rankList", method = RequestMethod.GET)
    public Object rankOfSongListId(HttpServletRequest req) {
        String songListId = req.getParameter("songListId");
        
        return new SuccessMessage<Number>(null, rankListService.rankOfSongListId(Long.parseLong(songListId))).getMessage();
    }
    
    // 获取指定用户的歌单评分
    @RequestMapping(value = "/rankList/user", method = RequestMethod.GET)
    public Object getUserRank(HttpServletRequest req) {
        String consumerId = req.getParameter("consumerId");
        String songListId = req.getParameter("songListId");
//        ResponseEntity 是 Spring 框架中用于表示 HTTP 响应的类，它包含了响应的状态码、头信息和正文
        if (consumerId == null || consumerId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("用户未登录，故不能显示");
        }
        if (songListId == null || songListId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("songListId 不能为空");
        }
        return new SuccessMessage<Number>(null, rankListService.getUserRank(Long.parseLong(consumerId), Long.parseLong(songListId))).getMessage();

    }
}
