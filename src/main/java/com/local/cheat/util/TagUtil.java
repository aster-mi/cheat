package com.local.cheat.util;

import java.util.List;

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
	public static Tag getTag(List<Tag> tags,Integer tag_id){
		if(CollectionUtils.isEmpty(tags)) {
			return null;
		}
		return tags.stream().filter(tag->tag.getId().equals(tag_id)).findFirst().get();
	}
	
	
}
