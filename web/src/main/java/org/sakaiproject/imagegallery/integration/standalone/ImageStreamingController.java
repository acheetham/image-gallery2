/**********************************************************************************
*
* $Id$
*
***********************************************************************************
*
* Copyright (c) 2008 The Regents of the University of California
*
* Licensed under the Educational Community License, Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.opensource.org/licenses/ecl1.php
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
**********************************************************************************/

package org.sakaiproject.imagegallery.integration.standalone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.imagegallery.domain.ImageFile;
import org.sakaiproject.imagegallery.integration.FileLibraryService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 */
public class ImageStreamingController extends AbstractController {
	private static final Log log = LogFactory.getLog(ImageStreamingController.class);
	private FileLibraryService fileLibraryService;

	/**
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (log.isInfoEnabled()) log.info("req contextPath=" + request.getContextPath() + ", pathInfo=" + request.getPathInfo() + 
				", query=" + request.getQueryString() + ", URI=" + request.getRequestURI() + ", URL=" + request.getRequestURL() + ", servlet=" + request.getServletPath());
		String fileId = request.getPathInfo().substring(1);
		ImageFile imageFile = fileLibraryService.getImageFile(fileId);
		response.setContentType(imageFile.getContentType());
		FileStreamer fileStreamer = (FileStreamer)fileLibraryService;
		fileStreamer.streamImage(fileId, response.getOutputStream());
		return null;
	}

	public void setFileLibraryService(FileLibraryService fileLibraryService) {
		this.fileLibraryService = fileLibraryService;
	}
}
