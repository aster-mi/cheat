package com.local.cheat.util;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.local.cheat.model.Tag;

@Component
public class TagUtil {
	
	/**
	 * ユーザーの持っているタグ一覧からタグを特定する
	 * @param tags
	 * @param tag_id
	 * @return
	 */
	public static Tag getTag(List<Tag> tags,Integer tagId){
		if(CollectionUtils.isEmpty(tags) || Objects.isNull(tagId)) {
			return null;
		}
		return tags.stream().filter(tag->tag.getId().equals(tagId)).findFirst().orElse(null);
	}
	
	
}
