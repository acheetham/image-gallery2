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

package org.sakaiproject.imagegallery.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.org.ponder.rsf.components.UICommand;
import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIForm;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;
import uk.org.ponder.rsf.viewstate.ViewParameters;

/**
 *
 */
public class AddImagesProducer extends AbstractViewProducer implements ViewComponentProducer {
	private static final Log log = LogFactory.getLog(AddImagesProducer.class);

	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		UIInternalLink.make(tofill, "browseImages-link", new SimpleViewParameters(getProducerViewID(BrowseImagesProducer.class)));
		UIForm newImageForm = UIForm.make(tofill, "new-image-form");
		UICommand.make(newImageForm, "image-add-information");
	}
}
