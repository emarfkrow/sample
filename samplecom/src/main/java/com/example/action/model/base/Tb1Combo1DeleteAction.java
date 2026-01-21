package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Combo1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合１削除
 *
 * @author emarfkrow
 */
public class Tb1Combo1DeleteAction extends BaseAction {

    /** 複合１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object refer1Id = postJson.get("refer1Id");
        if (refer1Id == null) {
            refer1Id = postJson.get("Tb1Combo1.refer1Id");
        }
        if (refer1Id == null) {
            throw new OptLockError("error.cant.delete", "複合１");
        }
        Object refer2Id = postJson.get("refer2Id");
        if (refer2Id == null) {
            refer2Id = postJson.get("Tb1Combo1.refer2Id");
        }
        if (refer2Id == null) {
            throw new OptLockError("error.cant.delete", "複合１");
        }

        Tb1Combo1 e = FormValidator.toBean(Tb1Combo1.class.getName(), postJson);

        java.util.List<com.example.entity.Tb1Combo2> tb1Combo2s = e.referTb1Combo2s();
        if (tb1Combo2s != null) {
            for (com.example.entity.Tb1Combo2 tb1Combo2 : tb1Combo2s) {

                if (tb1Combo2.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "複合２");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "複合１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
