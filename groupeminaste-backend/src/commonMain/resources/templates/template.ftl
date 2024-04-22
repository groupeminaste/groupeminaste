<#macro page>
    <!DOCTYPE html>
    <html lang="${locale}">
    <head>
        <meta charset="UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title><#if title??>${title} - </#if>Groupe MINASTE</title>
        <link rel="icon" href="/img/logo-bigger.png">
        <link href="/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
              integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
              crossorigin="anonymous">
    </head>
    <body>
    <!-- ====== Navbar Section Start -->
    <header class="header bg-transparent absolute top-0 left-0 z-40 w-full flex items-center transition">
        <div class="container">
            <div class="flex mx-[-16px] items-center justify-between relative">
                <div class="px-4">
                    <a href="/${locale}" class="header-logo block py-6 lg:py-8">
                        <img src="/img/logo-bigger-alt.png" alt="logo" class="rounded" width="36" height="36"/>
                    </a>
                </div>
                <div class="flex px-4 justify-between items-center w-full">
                    <div>
                        <button id="navbarToggler" name="navbarToggler" aria-label="navbarToggler"
                                class="block absolute right-4 top-1/2 translate-y-[-50%] lg:hidden focus:ring-2 ring-primary px-3 py-[6px] rounded-lg">
                            <span class="relative w-[30px] h-[2px] my-[6px] block bg-dark"></span>
                            <span class="relative w-[30px] h-[2px] my-[6px] block bg-dark"></span>
                            <span class="relative w-[30px] h-[2px] my-[6px] block bg-dark"></span>
                        </button>
                        <nav id="navbarCollapse"
                             class="absolute py-5 lg:py-0 lg:px-4 xl:px-6 bg-white lg:bg-transparent shadow-lg rounded-lg max-w-[250px] w-full lg:max-w-full lg:w-full right-4 top-full hidden lg:block lg:static lg:shadow-none">
                            <ul class="block lg:flex">
                                <li class="relative group">
                                    <a href="/${locale}"
                                       class="text-base text-black group-hover:text-primary py-2 lg:py-6 lg:inline-flex lg:px-0 flex mx-8 lg:mr-0">
                                        <@t key="menu_home"/>
                                    </a>
                                </li>
                                <li class="relative group">
                                    <a href="/${locale}/projects"
                                       class="text-base text-black group-hover:text-primary py-2 lg:py-6 lg:inline-flex lg:px-0 flex mx-8 lg:mr-0 lg:ml-8 xl:ml-12">
                                        <@t key="menu_projects"/>
                                    </a>
                                </li>
                                <li class="relative group">
                                    <a href="/${locale}#contact"
                                       class="text-base text-black group-hover:text-primary py-2 lg:py-6 lg:inline-flex lg:px-0 flex mx-8 lg:mr-0 lg:ml-8 xl:ml-12">
                                        <@t key="menu_contact"/>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div class="sm:flex justify-end hidden pr-16 lg:pr-0">
                        <a href="/${locale}#contact"
                           class="text-base font-bold text-white bg-primary rounded-full py-3 px-8 md:px-9 lg:px-8 xl:px-9 hover:shadow-signUp hover:bg-opacity-90 transition ease-in-out duration-300">
                            <@t key="home_contact_title" />
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ====== Navbar Section End -->

    <#nested>

    <!-- ====== Footer Section Start  -->
    <footer class="bg-black pt-[100px] pb-12 relative z-10">
        <div class="container">
            <div class="flex flex-wrap -mx-4">
                <div class="w-full lg:w-4/12 px-4">
                    <div class="mb-10">
                        <h2 class="font-bold text-white text-[44px] leading-tight mb-5"><@t key="footer_lets_talk" /></h2>
                        <h3 class="font-bold text-white opacity-70 text-2xl mb-2"><@t key="footer_contact" /></h3>
                        <p class="font-medium text-base text-body-color mb-2">
                            <a href="mailto:contact@groupe-minaste.org">contact@groupe-minaste.org</a>
                        </p>
                        <p class="font-medium text-base text-body-color mb-2">
                            79 Quai Panhard et Levassor<br/>75013 Paris, France
                        </p>
                        <p class="font-medium text-base text-body-color mb-2">
                            <a href="tel:+33666586516">🇫🇷 +33 6 66 58 65 16</a>
                        </p>

                        <p class="font-medium text-base text-body-color mb-2">
                            <a href="/mentions-legales">Mentions légales</a>
                        </p>
                    </div>
                </div>
                <div class="w-full md:w-1/2 lg:w-4/12 px-4">
                    <div class="mb-10">
                        <h3 class="font-semibold text-white text-xl mb-9">Non-profit</h3>
                        <ul>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="w-full md:w-1/2 lg:w-4/12 px-4">
                    <div class="mb-10">
                        <h3 class="font-semibold text-white text-xl mb-9">Business</h3>
                        <ul>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"
                                   class="inline-block text-base text-body-color mb-3 hover:text-primary">Link</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="mt-10 pt-12 border-t border-white border-opacity-10">
                <p class="font-medium text-base text-body-color text-center">© 2024 Groupe MINASTE</p>
            </div>
        </div>

        <div class="absolute left-0 bottom-0 -z-1" aria-label="shape" name="shape">
            <span class="hidden">shape</span>
            <svg width="143" height="138" viewBox="0 0 143 138" fill="none" xmlns="http://www.w3.org/2000/svg">
                <circle cx="25" cy="118" r="101" stroke="url(#paint0_linear_52:83)" stroke-width="34"/>
                <defs>
                    <linearGradient id="paint0_linear_52:83" x1="-12.7969" y1="-37.3359" x2="99.2109" y2="173.773"
                                    gradientUnits="userSpaceOnUse">
                        <stop stop-color="#4A6CF7"/>
                        <stop offset="1" stop-color="#4A6CF7" stop-opacity="0"/>
                    </linearGradient>
                </defs>
            </svg>
        </div>
        <div class="absolute right-3 top-3 -z-1" aria-label="shape" name="shape">
            <span class="hidden">shape</span>
            <svg width="61" height="77" viewBox="0 0 61 77" fill="none" xmlns="http://www.w3.org/2000/svg">
                <g opacity="0.5">
                    <circle cx="45.0001" cy="1.66667" r="1.66667" transform="rotate(90 45.0001 1.66667)" fill="white"/>
                    <circle cx="16.0001" cy="1.66667" r="1.66667" transform="rotate(90 16.0001 1.66667)" fill="white"/>
                    <circle cx="59.0001" cy="1.66667" r="1.66667" transform="rotate(90 59.0001 1.66667)" fill="white"/>
                    <circle cx="30.6668" cy="1.66667" r="1.66667" transform="rotate(90 30.6668 1.66667)" fill="white"/>
                    <circle cx="1.66683" cy="1.66667" r="1.66667" transform="rotate(90 1.66683 1.66667)" fill="white"/>
                    <circle cx="45.0001" cy="16.3332" r="1.66667" transform="rotate(90 45.0001 16.3332)" fill="white"/>
                    <circle cx="16.0001" cy="16.3332" r="1.66667" transform="rotate(90 16.0001 16.3332)" fill="white"/>
                    <circle cx="59.0001" cy="16.3332" r="1.66667" transform="rotate(90 59.0001 16.3332)" fill="white"/>
                    <circle cx="30.6668" cy="16.3332" r="1.66667" transform="rotate(90 30.6668 16.3332)" fill="white"/>
                    <circle cx="1.66683" cy="16.3332" r="1.66667" transform="rotate(90 1.66683 16.3332)" fill="white"/>
                    <circle cx="45.0001" cy="31.0002" r="1.66667" transform="rotate(90 45.0001 31.0002)" fill="white"/>
                    <circle cx="45.0001" cy="74.6667" r="1.66667" transform="rotate(90 45.0001 74.6667)" fill="white"/>
                    <circle cx="16.0001" cy="31.0002" r="1.66667" transform="rotate(90 16.0001 31.0002)" fill="white"/>
                    <circle cx="16.0001" cy="74.6667" r="1.66667" transform="rotate(90 16.0001 74.6667)" fill="white"/>
                    <circle cx="59.0001" cy="31.0002" r="1.66667" transform="rotate(90 59.0001 31.0002)" fill="white"/>
                    <circle cx="59.0001" cy="74.6667" r="1.66667" transform="rotate(90 59.0001 74.6667)" fill="white"/>
                    <circle cx="30.6668" cy="31.0002" r="1.66667" transform="rotate(90 30.6668 31.0002)" fill="white"/>
                    <circle cx="30.6668" cy="74.6667" r="1.66667" transform="rotate(90 30.6668 74.6667)" fill="white"/>
                    <circle cx="1.66683" cy="31.0002" r="1.66667" transform="rotate(90 1.66683 31.0002)" fill="white"/>
                    <circle cx="1.66683" cy="74.6667" r="1.66667" transform="rotate(90 1.66683 74.6667)" fill="white"/>
                    <circle cx="45.0001" cy="45.6667" r="1.66667" transform="rotate(90 45.0001 45.6667)" fill="white"/>
                    <circle cx="16.0001" cy="45.6667" r="1.66667" transform="rotate(90 16.0001 45.6667)" fill="white"/>
                    <circle cx="59.0001" cy="45.6667" r="1.66667" transform="rotate(90 59.0001 45.6667)" fill="white"/>
                    <circle cx="30.6668" cy="45.6667" r="1.66667" transform="rotate(90 30.6668 45.6667)" fill="white"/>
                    <circle cx="1.66683" cy="45.6667" r="1.66667" transform="rotate(90 1.66683 45.6667)" fill="white"/>
                    <circle cx="45.0001" cy="60.3332" r="1.66667" transform="rotate(90 45.0001 60.3332)" fill="white"/>
                    <circle cx="16.0001" cy="60.3332" r="1.66667" transform="rotate(90 16.0001 60.3332)" fill="white"/>
                    <circle cx="59.0001" cy="60.3332" r="1.66667" transform="rotate(90 59.0001 60.3332)" fill="white"/>
                    <circle cx="30.6668" cy="60.3332" r="1.66667" transform="rotate(90 30.6668 60.3332)" fill="white"/>
                    <circle cx="1.66683" cy="60.3332" r="1.66667" transform="rotate(90 1.66683 60.3332)" fill="white"/>
                </g>
            </svg>
        </div>
    </footer>
    <!-- ====== Footer Section End  -->

    <!-- ====== Back To Top Start -->
    <a href="javascript:void(0)"
       class="hidden items-center justify-center bg-primary text-white w-10 h-10 rounded-md fixed bottom-8 right-8 left-auto z-[999] hover:shadow-signUp transition duration-300 back-to-top">
        <span class="w-3 h-3 border-t border-l border-white rotate-45 mt-[6px]"></span>
    </a>
    <!-- ====== Back To Top End -->

    <!-- ====== All Scripts -->
    <script src="/js/script.js"></script>
    <script defer src="/js/bundle.js"></script>
    </body>
    </html>
</#macro>
