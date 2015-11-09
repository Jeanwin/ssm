package com.zonekey.ssm.views;
/**
 * 图片上传实体类
 * @author admin
 *
 */
public class Image {
	private String name;
	private String extension;
	private String size;
	private String width;
	private String height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Image [name=" + name + ", extension=" + extension + ", size=" + size + ", width=" + width + ", height=" + height + "]";
	}
}
