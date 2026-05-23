package com.example.action.D0000;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Ko;
import com.example.entity.T01Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;

/**
 * 詳細画面削除アクション
 * @author toshiyuki
 *
 */
public class D0002DeleteAction extends BaseAction {

    /**
     *
     */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String id, final Map<String, Object> postJson) {

        Object oyaId = postJson.get("oyaId");
        T01Oya e = T01Oya.get(oyaId);
        e.referT01Dinkss();
        e.referT01Kos();
        for (T01Ko t01Ko : e.getT01Kos()) {
            t01Ko.referT01Magos();
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "親");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
