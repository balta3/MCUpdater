package org.smbarbour.mcu.util;

import java.util.Locale;

public class ModuleAddon {
	private String url;
	private String path;
	private String md5;
    private String forModule;
	private Boolean inZip;

	public ModuleAddon(String url, String path, String md5, String forModule, Boolean inJar)
	{
		setUrl(url);
		setPath(path);
		setMD5(md5);
        setForModule(forModule);
		setInZip(inJar);
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getMD5()
	{
		return md5;
	}

	public void setMD5(String md5)
	{
		if( md5 != null )
			this.md5 = md5.toLowerCase(Locale.ENGLISH);
	}

    public String getForModule() {
        return forModule;
    }

    public void setForModule(String forModule) {
        this.forModule = forModule;
    }

	public Boolean getInZip()
	{
		return inZip;
	}

	public void setInZip(Boolean inZip)
	{
		this.inZip = inZip;
	}

	@Override
	public String toString() {
		return path;
	}
}
