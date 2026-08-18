package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Entity;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T00_ENTITY照会
 *
 * @author emarfkrow
 */
public class T00EntityGetAction extends BaseAction {

    /** T00_ENTITY照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object entityId = form.get("entityId");
        if (entityId == null) {
            entityId = form.get("T00Entity.entityId");
        }
        if (entityId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T00Entity t00Entity = T00Entity.get(entityId);
            map.put("T00Entity", t00Entity);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
