package com.fx.site.dto;

import com.fx.site.entity.MetaEntity;
import com.google.common.base.Converter;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 15:55
 * @description:
 */
@Getter
@Setter
public class MetaDto {

    private int count;

    /**
     * 名称
     */
    @NonNull
    private String name;

    /**
     * 项目缩略名
     */
    private String slug;

    /**
     * 选项描述
     */
    private String description;


    /**
     * 自定义转化器
     */
    private static class MetaDTOConvert extends Converter<MetaDto, MetaEntity> {
        @Override
        protected MetaEntity doForward(MetaDto metaDto) {
            MetaEntity meta = new MetaEntity();
            BeanUtils.copyProperties(metaDto, meta);
            return meta;
        }

        @Override
        protected MetaDto doBackward(MetaEntity metaEntity) {
            /*throw new AssertionError("不支持逆向转化方法!");*/
            MetaDto metaDto = new MetaDto();
            BeanUtils.copyProperties(metaEntity, metaDto);
            return metaDto;
        }

    }

    public MetaEntity converterToMetaEntity() {
        MetaDTOConvert convert = new MetaDTOConvert();
        MetaEntity metaEntity = convert.convert(this);
        return metaEntity;
    }

    public MetaDto coverterFor(MetaEntity entity) {
        MetaDTOConvert userDTOConvert = new MetaDTOConvert();
        MetaDto convert = userDTOConvert.reverse().convert(entity);
        return convert;
    }

}
