<#import "../template.ftl" as template>
<@template.page>
    <div class="container-fluid py-4">
        <div class="row">
            <div class="col-md-12">
                <div class="card card-body mt-4">
                    <h6 class="mb-0" id="admin_delete"><@t key="admin_" + route + "_delete" /></h6>
                    <hr class="horizontal dark my-3">

                    <form method="post" id="form">
                        <div class="d-flex justify-content-end mt-3">
                            <a class="btn btn-light m-0" href="../../${route}">
                                <@t key="admin_cancel" />
                            </a>
                            <input type="submit"
                                   class="btn btn-danger m-0 ms-2"
                                   value="<@t key="admin_delete" />">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@template.page>
