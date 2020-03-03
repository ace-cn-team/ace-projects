package ace.image.verify.code.base.api.web.application.biz.imageverifycode.util;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/3 11:26
 * @description
 */
public final class ImageVerifyCodeUtils {
    public static String getCacheKey(String imageVerifyCodeBizId){
        return String.format("ace:image-verify-code:%s", imageVerifyCodeBizId);
    }
}
