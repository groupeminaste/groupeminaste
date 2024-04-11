<#import "../template.ftl" as template>
<@template.page>
    <div class="container-fluid py-4">
        <div class="d-sm-flex justify-content-between">
            <div>
                <a href="${route}/create" class="btn btn-icon btn-outline-primary" id="admin_create">
                    <@t key="admin_" + route + "_create" />
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="table-responsive">
                        <table class="table table-flush" id="datatable-search">
                            <thead class="thead-light">
                            <tr>
                                <#list keys as key>
                                    <th id="th_${key.key}"><@t key="admin_${route}_${key.key}" /></th>
                                </#list>
                            </tr>
                            </thead>
                            <tbody>
                            <#list items as item>
                                <tr>
                                    <#list keys as key>
                                        <@cell item key />
                                    </#list>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@3.0.2/dist/umd/simple-datatables.js"></script>
    <script>
        const dataTableSearch = new simpleDatatables.DataTable("#datatable-search", {
            searchable: true,
            fixedHeight: false,
            perPageSelect: false
        });
    </script>
</@template.page>

<#macro cell item key>
    <td class="font-weight-bold">
        <#switch key.type>
            <#case "id">
                <span class="my-2 text-xs">
                    <a href="${route}/${item[key.key]}/update">${item[key.key]}</a>
                </span>
                <#break>
            <#case "password">
                <span class="my-2 text-xs">********</span>
                <#break>
            <#case "boolean">
                <div class="text-xs d-flex align-items-center">
                    <button class="btn btn-icon-only btn-rounded btn-outline-<#if item[key.key]>success<#else>danger</#if> mb-0 me-2 btn-sm d-flex align-items-center justify-content-center">
                        <i class="fas fa-<#if item[key.key]>check<#else>times</#if>" aria-hidden="true"></i>
                    </button>
                    <span>
                        <#if item[key.key]>
                            <@t key="boolean_true" />
                        <#else>
                            <@t key="boolean_false" />
                        </#if>
                    </span>
                </div>
                <#break>
            <#case "url_webpages">
                <span class="my-2 text-xs">
                    <a href="/pages/${item[key.key]}">/pages/${item[key.key]}</a>
                </span>
                <#break>
            <#default>
                <span class="my-2 text-xs">${item[key.key]}</span>
        </#switch>
    </td>
</#macro>
