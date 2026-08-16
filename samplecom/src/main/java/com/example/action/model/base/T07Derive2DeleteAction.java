package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生２削除
 *
 * @author emarfkrow
 */
public class T07Derive2DeleteAction extends BaseAction {

    /** 派生２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object derive2Id = postJson.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = postJson.get("T07Derive2.derive2Id");
        }
        if (derive2Id == null) {
            throw new OptLockError("error.cant.delete", "派生２");
        }

        T07Derive2 e = FormValidator.toBean(T07Derive2.class.getName(), postJson);

        java.util.List<com.example.entity.T07Derive2Det> t07Derive2Dets = e.referT07Derive2Dets();
        if (t07Derive2Dets != null) {
            for (com.example.entity.T07Derive2Det t07Derive2Det : t07Derive2Dets) {

                if (t07Derive2Det.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "派生２明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "派生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
