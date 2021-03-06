if(window.Tea == undefined) {
	Tea = {};
	Tea.ctx = undefined;
}
if(Tea.Modules == undefined)
	Tea.Modules = {};

Tea.Modules.Render = {
		
	user : '',
	entitledElements : [],
	
	initHeader:function() {
	},
	
	initIndexPage : function(username) {
		
		Tea.Modules.Render.user = username;
		if(username === '') {
			username = '游客';
		} else {
			//retrieve the user entitled elements from db
			Tea.Modules.Render.initUserEntitlement();
		}
		
		$('#welcome').html('[' + username + ']');
		
		//set the first tab to be current
		$('#headMain > #tabs > ul > li').first().addClass('current');
		
		//hide all the modules
		$('.module').hide();
		
		Tea.Modules.Render.bindNavTabEvent();
		
	},
	
	bindNavTabEvent : function() {
		
		$('#headMain > #tabs > ul > li').click(function() {
			
			var authorizedFlag = true; 
			
			switch($(this).attr('id')) {
			case 'navTabHome':
				break;
			case 'navTabBusiness':
				if(!Tea.Modules.Render.validateEntitlement('NAV_TAB_BUSINESS')) {
					authorizedFlag = false;
					alert('Not Authorized!');
				}
				break;
			case 'navTabUser':
				if(!Tea.Modules.Render.validateEntitlement('NAV_TAB_USER')) {
					authorizedFlag = false;
					alert('Not Authorized!');
				}
				break;
			case 'navTabReport':
				if(!Tea.Modules.Render.validateEntitlement('NAV_TAB_REPORT')) {
					authorizedFlag = false;
					alert('Not Authorized!');
				}
				break;
			case 'navTabFile':
				if(Tea.Modules.Render.validateEntitlement('NAV_TAB_FILE')) {
					$('#fileMain').show();
				} else {
					authorizedFlag = false;
					alert('Not Authorized!');
				}
				break;
			case 'navTabContact':
				break;
			default :;
			}
			
			//not authorized
			if(authorizedFlag) {
				Tea.Modules.Render.setCurrentNavTabAvailable($(this));
			}
			
		});
		
	},
	
	setCurrentNavTabAvailable : function(obj) {
		$(obj).siblings().removeClass('current');
		$(obj).addClass('current');
	},
	
	
	
	validateEntitlement : function(element) {
		
		//Not yet login or actually has no privileges to any element
		if(element, Tea.Modules.Render.entitledElements.length == 0)
			return false;
		if($.inArray(element, Tea.Modules.Render.entitledElements) != -1) {
			return true;
		} else {
			return false;
		}
		
	},
	
	initUserEntitlement : function() {
		var entitlement = ['NAV_TAB_USER', 'NAV_TAB_BUSINESS', 'NAV_TAB_FILE'];
		Tea.Modules.Render.entitledElements = entitlement;
		
		/*if(Tea.Modules.Render.user != '') {
		var credential = {userName: Tea.Modules.Render.user};
		url = Tea.ctx + '/user/getElements';
		$.ajax({
			url : url,
			type : 'post',
			datatype : 'json',
			contentType: "application/json",
			data : JSON.stringify(credential),
			success : function(data, stats) {
				console.debug(data);
			},
			error : function(data) {
				alert('failed to post the request.');
			}
		});
	}*/
	},
	
	initLoginPage : function() {
		$('#headMain > #tabs > ul > li').unbind();
	},
	
}