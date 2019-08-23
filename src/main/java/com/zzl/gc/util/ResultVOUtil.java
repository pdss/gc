package com.zzl.gc.util;

import com.zzl.gc.VO.ResultVO;
import lombok.Data;

/**
 * @author luotao
 * @Package com.zzl.gc.util
 * @date 2019/8/23 14:16
 */
@Data
public class ResultVOUtil<T> {
    public static<T> ResultVO success(T data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }
    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
    public static ResultVO error(int code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
