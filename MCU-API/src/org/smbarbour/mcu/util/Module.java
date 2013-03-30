package org.smbarbour.mcu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Module {
	private String name;
	private String id;
	private String url;
	private String path;
	private String depends;
	private Boolean required;
	private Boolean inJar;
	private int jarOrder;
	private Boolean extract;
	private Boolean inRoot;
	private Boolean isDefault;
	private Boolean coreMod;
    private Boolean texturePack;
	private String md5;
	private ModSide side;
	private List<ConfigFile> configs;
	private List<ModuleAddon> addons;

	public Module(String name, String id, String url, String depends, Boolean required, Boolean inJar, int jarOrder, Boolean extract, Boolean inRoot, Boolean isDefault, Boolean coreMod, Boolean texturePack, String md5, List<ConfigFile> configs, List<ModuleAddon> addons, String side, String path)
	{
		this.setName(name);
		this.setId(id);
		this.setUrl(url);
		this.setDepends(depends);
		this.setRequired(required);
		this.setInJar(inJar);
		this.setJarOrder(jarOrder);
		this.setIsDefault(isDefault);
		this.setExtract(extract);
		this.setInRoot(inRoot);
		this.setCoreMod(coreMod);
        this.setTexturePack(texturePack);
		this.setMD5(md5);
		this.setSide(side);
		this.setPath(path);
		if(configs != null)
		{
			this.configs = configs;
		} else {
			this.configs = new ArrayList<ConfigFile>();
		}
		if(addons != null)
		{
			this.addons = addons;
		} else {
			this.addons = new ArrayList<ModuleAddon>();
		}
	}

	private void setJarOrder(int jarOrder) {
		this.jarOrder = jarOrder;
	}

	@Deprecated
	public Module(String name, String id, String url, String depends, Boolean required, Boolean inJar, Boolean extract, Boolean inRoot, Boolean isDefault, Boolean coreMod, String md5, List<ConfigFile> configs)
	{
		this(name, id, url, depends, required, inJar, 0, extract, inRoot, isDefault, coreMod, false, md5, configs, null, null, null);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url=url;
	}

	public Boolean getRequired()
	{
		return required;
	}

	public void setRequired(Boolean required)
	{
		this.required=required;
	}

	public Boolean getInJar()
	{
		return inJar;
	}

	public void setInJar(Boolean inJar)
	{
		this.inJar=inJar;
	}

	public Boolean getExtract() {
		return extract;
	}

	public void setExtract(Boolean extract) {
		this.extract = extract;
	}

	public Boolean getInRoot() {
		return inRoot;
	}

	public void setInRoot(Boolean inRoot) {
		this.inRoot = inRoot;
	}

	public String getMD5() {
		return (md5 == null ? "" : md5);
	}

	public void setMD5(String md5) {
		if( md5 != null )
			this.md5 = md5.toLowerCase(Locale.ENGLISH);
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public List<ConfigFile> getConfigs()
	{
		return configs;
	}

	public void setConfigs(List<ConfigFile> configs)
	{
		this.configs = configs;
	}

    public List<ModuleAddon> getAddons() {
        return addons;
    }

    public void setAddons(List<ModuleAddon> addons) {
        this.addons = addons;
    }

	public Boolean getCoreMod() {
		return coreMod;
	}

	public void setCoreMod(Boolean coreMod) {
		this.coreMod = coreMod;
	}

	public Boolean getTexturePack() {
		return texturePack;
	}

	public void setTexturePack(Boolean texturePack) {
		this.texturePack = texturePack;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepends() {
		return depends;
	}

	public void setDepends(String depends) {
		this.depends = depends;
	}

	@Override
	public String toString() {
		return id;
	}

	public ModSide getSide() {
		return side;
	}

	public void setSide(ModSide side) {
		this.side = side;
	}
	public void setSide(String side) {
		if( side == null || side.length() == 0 ) {
			side = "BOTH";
		} else {
			side = side.toUpperCase();
		}
		try {
			setSide( ModSide.valueOf(side) );
		} catch( IllegalArgumentException e ) {
			setSide( ModSide.BOTH );
		}
	}

	public boolean isClientSide() {
		return side != ModSide.SERVER;
	}
	public boolean isServerSide() {
		return side != ModSide.CLIENT;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if (path == null) {
			path = "";
		}
		this.path = path;
	}

	public int getJarOrder() {
		return jarOrder;
	}

}

