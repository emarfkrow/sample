package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T08Kisei1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T08_KISEI1照会
 *
 * @author emarfkrow
 */
public class T08Kisei1GetAction extends BaseAction {

    /** T08_KISEI1照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kisei1Id = form.get("kisei1Id");
        if (kisei1Id == null) {
            kisei1Id = form.get("T08Kisei1.kisei1Id");
        }
        if (kisei1Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T08Kisei1 t08Kisei1 = T08Kisei1.get(kisei1Id);
            map.put("T08Kisei1", t08Kisei1);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
