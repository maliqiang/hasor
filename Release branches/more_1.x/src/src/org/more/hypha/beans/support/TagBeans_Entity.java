/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.more.hypha.beans.support;
import java.util.HashMap;
import java.util.Map;
import org.more.core.xml.XmlStackDecorator;
import org.more.core.xml.stream.StartElementEvent;
import org.more.hypha.beans.define.MapEntity_ValueMetaData;
import org.more.hypha.beans.define.PropertyType;
import org.more.hypha.beans.define.Simple_ValueMetaData;
import org.more.hypha.context.XmlDefineResource;
/**
 * 用于解析entity标签
 * @version 2010-9-23
 * @author 赵永春 (zyc@byshell.org)
 */
public class TagBeans_Entity extends TagBeans_AbstractValueMetaDataDefine<MapEntity_ValueMetaData> {
    /**创建{@link TagBeans_Entity}对象*/
    public TagBeans_Entity(XmlDefineResource configuration) {
        super(configuration);
    }
    /**创建{@link MapEntity_ValueMetaData}对象。*/
    protected MapEntity_ValueMetaData createDefine() {
        return new MapEntity_ValueMetaData();
    }
    /**定义模板属性。*/
    public enum PropertyKey {
        key, value
    }
    /**关联属性与xml的属性对应关系。*/
    protected Map<Enum<?>, String> getPropertyMappings() {
        HashMap<Enum<?>, String> propertys = new HashMap<Enum<?>, String>();
        //propertys.put(PropertyKey.key, "key");
        //propertys.put(PropertyKey.value, "value");
        return propertys;
    }
    public void beginElement(XmlStackDecorator context, String xpath, StartElementEvent event) {
        super.beginElement(context, xpath, event);
        MapEntity_ValueMetaData mapEntity = this.getDefine(context);
        String key = event.getAttributeValue("key");
        String var = event.getAttributeValue("value");
        //
        if (key != null) {
            Simple_ValueMetaData keyData = new Simple_ValueMetaData();
            keyData.setValue(key);
            keyData.setValueMetaType(PropertyType.String);
            mapEntity.setKey(keyData);
        }
        if (var != null) {
            Simple_ValueMetaData varData = new Simple_ValueMetaData();
            varData.setValue(var);
            varData.setValueMetaType(PropertyType.String);
            mapEntity.setVarObject(varData);
        }
    }
}