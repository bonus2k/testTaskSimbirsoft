<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <table class="table table-sm table-responsive-sm">
            <thead>
            <tr>
                <th scope="col"> ID </th>
                <th scope="col"> URL </th>
                <th scope="col"> Дата загрузки </th>
                <th scope="col"> Страница </th>
                <th scope="col"> Статистика </th>

            </tr>
            </thead>

            <tbody>
            <#list pages as page>
                <tr>

                    <td><b>${page.id?string["##########"]}</b></td>
                    <td><span>${page.url}</span></td>
                    <td><span>${page.dateUpload?string["d MMM, HH:mm"]}</span></td>
                    <td><span><a href="#" onClick="window.open('/html/${page.path}', 'newWin', 'Toolbar=0, Location=0, Directories=0, Status=0, Menubar=0, Scrollbars=0, Resizable=0, Copyhistory=1, Width=800, Height=600')"><i class="far fa-file-invoice"></i></a></span></td>
                    <td><span><a href="statisticPage/${page.id}/get"><i class="far fa-book"></i></a></span></td>
                </tr>
            <#else>
                <div>
                    <b>Нет записей</b>
                </div>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>