resource "oci_analytics_analytics_instance" "analytics_instance" {
    #Required
    capacity {
        #Required
        capacity_type = var.analytics_instance_capacity_capacity_type
        capacity_value = var.analytics_instance_capacity_capacity_value
    }
    compartment_id = var.compartment_ocid
    feature_set = var.analytics_instance_feature_set
    idcs_access_token = var.analytics_instance_idcs_access_token
    license_type = var.analytics_instance_license_type
    name = var.analytics_instance_name

    #Optional
    description = var.analytics_instance_description
    email_notification = var.analytics_instance_email_notification
    network_endpoint_details {
        #Required
        network_endpoint_type = var.analytics_instance_network_endpoint_details_network_endpoint_type

        #Optional
        whitelisted_ips = [var.analytics_instance_network_endpoint_details_whitelisted_ips]
    }
}