package com.kma.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import com.common.exception.BizException;
import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.kma.adapter.out.vo.ResUltraSrtNcstVOResponse;
import com.kma.adapter.out.vo.ResUltraSrtNcstVOResponseBodyItemsItemInner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 응답을 담는 domain
 */
@Getter
@ToString
@AllArgsConstructor
public class ResponseKMA {
  private String resultCode;
  private int nx;
  private int ny;
  private String baseDate;
  private String baseTime;

  private List<ItemKMA> items;

  public ResponseKMA(ResUltraSrtNcstVO resUltraSrtNcstVo) {
    resultCode = getResultCode(resUltraSrtNcstVo);
    ResUltraSrtNcstVOResponseBodyItemsItemInner itm = resUltraSrtNcstVo.getResponse().getBody().getItems().getItem().getFirst();
    ny = itm.getNy();
    nx = itm.getNx();
    baseDate = itm.getBaseDate();
    baseTime = itm.getBaseTime();
    items = new ArrayList<ItemKMA>();
  }

  public void addItem(ItemKMA itm) {
    items.add(itm);
  }

  /**
   * 응답이 성공인가?
   * 
   * @return
   */
  public boolean isSuccessfulResponse() {
    if (!"00".equals(resultCode)) {
      return false;
    }
    return true;
  }

  /**
   * 응답의 결과 값을 세팅합니다.
   * 
   * @param resUltraSrtNcstVo
   */
  public String getResultCode(ResUltraSrtNcstVO resUltraSrtNcstVo) {
    ResUltraSrtNcstVOResponse res = resUltraSrtNcstVo.getResponse();
    if (ObjectUtils.isEmpty(res)) {
      throw new BizException("KMA_ERR_RES_NULL", "MSG0002");
    } else {
      return res.getHeader().getResultCode();
    }
  }

}
