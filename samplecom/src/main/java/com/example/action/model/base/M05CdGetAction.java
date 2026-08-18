package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Cd;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * M05_CD照会
 *
 * @author emarfkrow
 */
public class M05CdGetAction extends BaseAction {

    /** M05_CD照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object cdrefCd = form.get("cdrefCd");
        if (cdrefCd == null) {
            cdrefCd = form.get("M05Cd.cdrefCd");
        }
        if (cdrefCd == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M05Cd m05Cd = M05Cd.get(cdrefCd);
            map.put("M05Cd", m05Cd);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
