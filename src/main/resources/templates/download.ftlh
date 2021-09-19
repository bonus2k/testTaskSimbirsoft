<#import "parts/common.ftlh" as c>
<@c.page>
  <#if message??>
      <div class="alert alert-danger my-3 w-50 flex-center" role="alert">
          ${message}
      </div>
  </#if>

  <form method="post">
  <div class="form-group row">
        <label class="col-sm-2 col-form-label">Введи URL страницы:</label>
        <div class="col-sm-6">
          <input type="text" name="url" class="form-control" placeholder="http://www.exampel.com"/>
        </div>
      </div>
    <div class="form-group row">
      <div class="col-auto my-3">
        <button class="btn btn-primary ">Сохранить</button>
      </div>
    </div>
  </form>

    <#if words??>
        <#list words as word>
            <h6>${word}</h6>
        </#list>
    </#if>
</@c.page>