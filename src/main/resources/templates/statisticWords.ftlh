<#import "parts/common.ftlh" as c>
<@c.page>
    <#if words??>
        <#list words as word>
            <h6>${word}</h6>
        </#list>
    </#if>
</@c.page>