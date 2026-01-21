package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb4KoOrphans;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 孤児照会
 *
 * @author emarfkrow
 */
public class Tb4KoOrphansGetAction extends BaseAction {

    /** 孤児照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("Tb4KoOrphans.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        Object koBn = postJson.get("koBn");
        if (koBn == null) {
            koBn = postJson.get("Tb4KoOrphans.koBn");
        }
        if (koBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb4KoOrphans tb4KoOrphans = Tb4KoOrphans.get(oyaId, koBn);
            // 兄弟
            tb4KoOrphans.referTb4Ko();
            tb4KoOrphans.referTb4KoDinks();
            // 子
            tb4KoOrphans.referTb4Magos();
            map.put("Tb4KoOrphans", tb4KoOrphans);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
