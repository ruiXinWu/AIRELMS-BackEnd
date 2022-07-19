package com.roncoo.education.system.dao;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.system.dao.impl.mapper.entity.WebsiteNavArticle;
import com.roncoo.education.system.dao.impl.mapper.entity.WebsiteNavArticleExample;

public interface WebsiteNavArticleDao {
    int save(WebsiteNavArticle record);

    int deleteById(Long id);

    int updateById(WebsiteNavArticle record);

    WebsiteNavArticle getById(Long id);

    Page<WebsiteNavArticle> listForPage(int pageCurrent, int pageSize, WebsiteNavArticleExample example);

    /**
     * 根据导航ID查找站点导航文章
     *
     * @param navId
     * @return
     * @author wuyun
     */
    WebsiteNavArticle getByNavId(Long id);

    /**
     * 根据导航ID和状态信息查找站点导航文章
     *
     * @param navId
     * @param statusId
     * @return
     * @author wuyun
     */
    WebsiteNavArticle getByNavIdAndStatusId(Long navId, Integer statusId);
}
