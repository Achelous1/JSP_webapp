<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <div class="col-sm-9">
        <h1>ooo님과의 대화</h1>
        <ul class="list-group">
          <li class="list-group-item">
              <div style="height: 500px;">
                    <!-- 상대대화내용 -->
                  <div class="media">
                      <div class="media-left">
                        <img src="#" class="media-object" style="width:60px">
                      </div>
                      <div class="media-body">
                        <h4 class="media-heading">엄동건</h4>
                        <p>안녕하세요</p>
                      </div>
                  </div>
                    <!-- 나의 대화내용 -->
                  <div class="media"align="right">
                    <div class="media-body" align="right">
                      <h4 class="media-heading">나</h4>
                      <p>네 안녕하세요</p>
                    </div>
                      <div class="media-right">
                        <img src="#" class="media-object" style="width:60px">
                      </div>
                  </div>
              </div>
          </li>
          <li class="list-group-item">
              <form action="/action_page.php">
              <div class="input-group">
                  <input type="text" class="form-control" placeholder="보낼 내용을 적어주세요~" name="message">
                  <div class="input-group-btn">
                    <button class="btn btn-warning btn-md" type="submit">쪽지 보내기</button>
                  </div>
              </div>
              </form>
          </li>
        </ul>
      </div>

      <div class="col-sm-3">
        <div style="padding: 30px;">
          <table class="table">
            <thead>
              <tr>
                <th colspan="3"></th>
              </tr>
              <tbody>
                <tr>
                  <td><span class="label label-danger">5</span></td>
                  <td width="80%">ooo님과의 대화</td>
                  <td><a class="btn btn-primary btn-sm pull-right">대화하기</a></td>
                </tr>
                <tr>
                  <td><span class="label label-danger">9</span></td>
                  <td width="80%">ooo님과의 대화</td>
                  <td><a class="btn btn-primary btn-sm pull-right">대화하기</a></td>
                </tr>
                <tr>
                  <td><span class="label label-danger">12</span></td>
                  <td width="80%">ooo님과의 대화</td>
                  <td><a class="btn btn-primary btn-sm pull-right">대화하기</a></td>
                </tr>
                <tr>
                  <td colspan="3">
                    <ul class="pager">
                      <li><a href="#" class="btn btn-success">Prev</a></li>
                      <li><a href="#" class="btn btn-success">Next</a></li>
                    </ul>
                  </td>

                </tr>
              </tbody>
            </thead>
          </table>
        </div>
        <div style="padding: 30px;">
          <div style="background-color: white; padding: 5px; box-shadow: 3px 3px 3px rgba(133,133,133,0.60);" data-skyscanner-widget="SearchWidget"></div>
          <script src="https://widgets.skyscanner.net/widget-server/js/loader.js" async></script>
        </div>
      </div>
