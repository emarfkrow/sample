package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生１削除
 *
 * @author emarfkrow
 */
public class T07Derive1DeleteAction extends BaseAction {

    /** 派生１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object derive1Id = postJson.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = postJson.get("T07Derive1.derive1Id");
        }
        if (derive1Id == null) {
            throw new OptLockError("error.cant.delete", "派生１");
        }

        T07Derive1 e = FormValidator.toBean(T07Derive1.class.getName(), postJson);

        java.util.List<com.example.entity.T07Derive1Det> t07Derive1Dets = e.referT07Derive1Dets();
        if (t07Derive1Dets != null) {
            for (com.example.entity.T07Derive1Det t07Derive1Det : t07Derive1Dets) {

                if (t07Derive1Det.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "派生１明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "派生１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
