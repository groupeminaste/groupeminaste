<#import "../../template.ftl" as template>
<@template.page>
    <!-- ====== Blog Section Start -->
    <section class="pb-20 pt-[150px]">
        <div class="container">
            <div class="flex flex-wrap -mx-5">
                <div class="w-full lg:w-8/12 px-5">
                    <div>
                        <div class="rounded-sm mb-8">
                            <img src="${item.image}" alt="image" class="w-full object-cover object-center"/>
                        </div>
                        <h3 class="font-bold text-black text-2xl sm:text-4xl lg:text-3xl mb-7">${item.name}</h3>
                        <p class="text-base sm:text-lg lg:text-base xl:text-lg text-body-color mb-8">
                            ${item.description}
                        </p>
                    </div>
                </div>
                <div class="w-full lg:w-4/12 px-5">
                    <div class="bg-[#F8F9FF] border border-[#D7DFFF] py-9 px-6 sm:p-9 lg:px-6 xl:px-5 rounded-sm mb-10">
                        <h3 class="font-bold text-primary text-[22px] mb-7"><@t key="projects_info" /></h3>
                        <ul>
                            <li class="flex lg:flex-wrap xl:flex-nowrap mb-3">
                                <span class="max-w-[90px] w-full font-medium text-black text-base flex justify-between">
                                    <@t key="projects_category" />
                                    <span class="text-body-color">:</span>
                                </span>
                                <span class="w-full font-medium text-body-color text-base pl-5 lg:pl-0 xl:pl-5">${item.category}</span>
                            </li>
                            <li class="flex lg:flex-wrap xl:flex-nowrap mb-3">
                                <span class="max-w-[90px] w-full font-medium text-black text-base flex justify-between">
                                    <@t key="projects_updatedAt" />
                                    <span class="text-body-color">:</span>
                                </span>
                                <span class="w-full font-medium text-body-color text-base pl-5 lg:pl-0 xl:pl-5">${item.updatedAt}</span>
                            </li>
                        </ul>
                    </div>
                    <div class="bg-[#F8F9FF] border border-[#D7DFFF] py-9 px-6 sm:p-9 lg:px-6 xl:px-5 rounded-sm">
                        <h3 class="font-bold text-primary text-[22px] mb-7"><@t key="projects_links" /></h3>
                        <ul>
                            <#list links as link>
                                <li class="flex mb-4">
                                    <a href="${link.url}"
                                       class="w-full flex items-center font-medium text-base text-white bg-primary py-3 px-5 rounded-sm">
                                        <span>${link.name}</span>
                                    </a>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ====== Blog Section End -->
</@template.page>
