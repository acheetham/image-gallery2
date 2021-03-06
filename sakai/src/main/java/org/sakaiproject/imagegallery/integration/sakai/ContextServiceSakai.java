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

package org.sakaiproject.imagegallery.integration.sakai;

import org.sakaiproject.imagegallery.integration.ContextService;
import org.sakaiproject.tool.api.ToolManager;

/**
 *
 */
public class ContextServiceSakai implements ContextService {
	private ToolManager toolManager;

	/* (non-Javadoc)
	 * @see org.sakaiproject.imagegallery.integration.ContextService#getCurrentContextUid()
	 */
	public String getCurrentContextUid() {
		return toolManager.getCurrentPlacement().getContext();
	}

	public void setToolManager(ToolManager toolManager) {
		this.toolManager = toolManager;
	}

}
