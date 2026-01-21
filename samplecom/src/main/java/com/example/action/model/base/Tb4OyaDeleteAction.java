package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb4Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 親削除
 *
 * @author emarfkrow
 */
public class Tb4OyaDeleteAction extends BaseAction {

    /** 親削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("Tb4Oya.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.delete", "親");
        }

        Tb4Oya e = FormValidator.toBean(Tb4Oya.class.getName(), postJson);

        java.util.List<com.example.entity.Tb4Ko> tb4Kos = e.referTb4Kos();
        if (tb4Kos != null) {
            for (com.example.entity.Tb4Ko tb4Ko : tb4Kos) {

                // child:Tb4Mago, parents:2


                if (tb4Ko.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "子");
                }
            }
        }


        java.util.List<com.example.entity.Tb4KoDinks> tb4KoDinkss = e.referTb4KoDinkss();
        if (tb4KoDinkss != null) {
            for (com.example.entity.Tb4KoDinks tb4KoDinks : tb4KoDinkss) {

                if (tb4KoDinks.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "子なし");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "親");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
