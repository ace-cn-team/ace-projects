package ace.image.verify.code.define.base.model.request;

import ace.fw.util.AceEnumUtils;
import ace.image.verify.code.define.base.enums.ImageVerifyCodeTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 16:56
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetImageVerifyCodeRequest {
    @ApiModelProperty(value = "图片验证码图片宽度,默认:100", required = true)
    private Integer imageWidth = 100;
    @ApiModelProperty(value = "图片验证码图片高度，默认50", required = true)
    private Integer imageHeight = 50;
    @ApiModelProperty(value = "图片验证码长度,默认值：4", required = true)
    private Integer imageVerifyCodeCount = 4;
    @ApiModelProperty(value = "图片验证码字体大小,默认值：40", required = true)
    private Integer imageVerifyCodeFontSize = 40;
    @ApiModelProperty(value = "图片验证码类型，0-纯数字，1-纯字母，2-数字与字母", required = true)
    private Integer imageVerifyCodeType = 0;
    @ApiModelProperty(value = "业务ID", required = true)
    @NotBlank
    @Length(max = 36)
    private String imageVerifyCodeBizId;

    @ApiModelProperty(hidden = true)
    public ImageVerifyCodeTypeEnum getImageVerifyCodeTypeEnum() {
        return AceEnumUtils.getEnum(ImageVerifyCodeTypeEnum.class, this.imageVerifyCodeType);
    }
}
