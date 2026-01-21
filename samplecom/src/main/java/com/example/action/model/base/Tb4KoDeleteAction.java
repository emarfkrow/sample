package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb4Ko;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 子削除
 *
 * @author emarfkrow
 */
public class Tb4KoDeleteAction extends BaseAction {

    /** 子削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("Tb4Ko.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.delete", "子");
        }
        Object koBn = postJson.get("koBn");
        if (koBn == null) {
            koBn = postJson.get("Tb4Ko.koBn");
        }
        if (koBn == null) {
            throw new OptLockError("error.cant.delete", "子");
        }

        Tb4Ko e = FormValidator.toBean(Tb4Ko.class.getName(), postJson);

        // child:Tb4Mago, parents:2

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "子");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
