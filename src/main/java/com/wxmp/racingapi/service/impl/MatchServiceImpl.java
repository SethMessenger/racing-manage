package com.wxmp.racingapi.service.impl;

import com.wxmp.racingapi.service.MatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/6
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MatchServiceImpl implements MatchService{
}
