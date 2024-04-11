<#import "../template.ftl" as template>
<@template.page>
    <div class="container-fluid py-4">
        <div class="row">
            <div class="col-md-8">
                <div class="card card-body mt-4">
                    <#if item??>
                        <h6 class="mb-0" id="admin_update"><@t key="admin_" + route + "_update" /></h6>
                    <#else>
                        <h6 class="mb-0" id="admin_create"><@t key="admin_" + route + "_create" /></h6>
                    </#if>
                    <hr class="horizontal dark my-3">

                    <form method="post" id="form">
                        <div class="row">
                            <#list keys as key>
                                <@field key />
                            </#list>
                        </div>

                        <div class="d-flex justify-content-end mt-3">
                            <a class="btn btn-light m-0" href="../<#if item??>../</#if>${route}">
                                <@t key="admin_cancel" />
                            </a>
                            <#if item??>
                                <a class="btn btn-danger m-0 ms-2" href="delete">
                                    <@t key="admin_delete" />
                                </a>
                            </#if>
                            <input type="submit"
                                   class="btn bg-gradient-primary m-0 ms-2"
                                   value="<@t key="admin_save" />">
                        </div>
                    </form>
                </div>
            </div>
            <#if item??>
                <@children name=route />
            </#if>
        </div>
    </div>

    <#if flatpickr?? && flatpickr>
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
        <script>
            if (document.querySelector('.datetimepicker')) {
                flatpickr('.datetimepicker', {
                    allowInput: true,
                    enableTime: true,
                    dateFormat: "Z",
                    altInput: true,
                    altFormat: "d/m/Y à H:i"
                });
            }
        </script>
    </#if>
</@template.page>

<#macro field key>
    <#if key.type == "id">
        <#return />
    </#if>
    <div class="col-md-${key.style} mb-3">
        <label for="${key.key}" class="form-label">
            <@t key="admin_${route}_${key.key}" />
        </label>
        <#switch key.type>
            <#case "password">
                <input type="password" class="form-control"
                       name="${key.key}" id="${key.key}"
                       <#if !key.editable>disabled</#if>>
                <#break>
            <#case "boolean">
                <div class="form-check form-switch ms-1">
                    <input class="form-check-input" type="checkbox"
                           name="${key.key}" id="${key.key}"
                           <#if item?? && item[key.key]>checked</#if>>
                    <label class="form-check-label" for="${key.key}"></label>
                </div>
                <#break>
            <#case "integer">
                <input type="number" class="form-control"
                       name="${key.key}" id="${key.key}"
                       <#if item??>value="${item[key.key]}"</#if>
                        <#if !key.editable>disabled</#if>>
                <#break>
            <#case "date">
                <input type="text" class="form-control datetimepicker"
                       name="${key.key}" id="${key.key}"
                       <#if item??>value="${item[key.key]}"</#if>
                        <#if !key.editable>disabled</#if>>
                <#break>
            <#case "markdown">
                <textarea class="form-control"
                          name="${key.key}" id="${key.key}"
                          <#if !key.editable>disabled</#if>><#if item??>${item[key.key]}</#if></textarea>
                <#break>
            <#default>
                <input type="text" class="form-control"
                       name="${key.key}" id="${key.key}"
                       <#if item??>value="${item[key.key]}"</#if>
                        <#if !key.editable>disabled</#if>>
        </#switch>
    </div>
</#macro>

<#macro children name>
    <#switch name>
        <#case "projects">
            <#break>
    </#switch>
</#macro>
